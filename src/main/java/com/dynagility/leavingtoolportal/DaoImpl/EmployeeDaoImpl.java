package com.dynagility.leavingtoolportal.DaoImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dynagility.leavingtoolportal.Dao.AccountDao;
import com.dynagility.leavingtoolportal.Dao.EmployeeDao;
import com.dynagility.leavingtoolportal.Dao.Employee_ProjectDao;
import com.dynagility.leavingtoolportal.VO.AccountVO;
import com.dynagility.leavingtoolportal.VO.EmployeeVO;
import com.dynagility.leavingtoolportal.VO.Employee_ProjectVO;
import com.dynagility.leavingtoolportal.VO.PositionVO;
import com.dynagility.leavingtoolportal.VO.RoleVO;
import com.dynagility.leavingtoolportal.model.Employee;
import com.dynagility.leavingtoolportal.model.Position;
import com.dynagility.leavingtoolportal.model.mapper.EmployeeMapper;
import com.dynagility.leavingtoolportal.model.mapper.PositionMapper;
import com.dynagility.leavingtoolportal.model.mapper.RoleMapper;
@Repository
@Transactional
public  class EmployeeDaoImpl implements EmployeeDao {
    @PersistenceContext 
    private EntityManager entityManager;
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private Employee_ProjectDao emp_ProDao;
    private EmployeeMapper employeeMapper;
    private RoleMapper roleMapper;
    private PositionMapper positionMapper;
    @SuppressWarnings("unchecked")
    @Override
    public List<EmployeeVO> findAll(){
        String hql = "from Employee";
        List<Employee> employees = null;
        employees = entityManager.createQuery(hql).getResultList();

        List<EmployeeVO> emVos = new ArrayList<EmployeeVO>();
        for(Employee e : employees) {
            emVos.add(EmployeeMapper.updateEmployeeVO(e));
        }
        return emVos;
    }

    public Employee findById(String id) {
        String hql = "select e from Employee e where id =:id";
        Employee employee = null;
        employee =  (Employee) entityManager.createQuery(hql).setParameter("id", id).getSingleResult();
        return employee;
    }

    @Override
    public EmployeeVO findEmployeeById(String id) {
        return EmployeeMapper.updateEmployeeVO(findById(id));
    }

    @Override
    public EmployeeVO save(EmployeeVO employeeVO) {

        // Update Function
        if (employeeVO.getId() != null) {
              Employee employee = findById(employeeVO.getId());
              EmployeeMapper.updateEmployee(employeeVO, employee);

              entityManager.merge(employee);
              return EmployeeMapper.updateEmployeeVO(employee);
        }

        //Add New Function
        else {
            Employee employee =  new Employee();

            entityManager.persist(EmployeeMapper.updateEmployee(employeeVO, employee));
            return EmployeeMapper.updateEmployeeVO(employee);
        }
    }

    @Override
    public void delete(String id) {

        entityManager.remove(findById(id));
    }

	@Override
	public EmployeeVO findEmployeeByEmployeeId(String employee_Id) {
		AccountVO acc_VO = accountDao.findByEmployeeId(employee_Id);
		System.out.println(acc_VO.getUsername());
		EmployeeVO emp_VO = new EmployeeVO();
		emp_VO = employeeMapper.updateEmployeeVO(acc_VO.getEmployee());
		System.out.println(emp_VO.getEmail());
		RoleVO roleVO = roleMapper.updateRoleVO(acc_VO.getRole());
		emp_VO.setRole(roleVO);
		PositionVO positionVO = positionMapper.updateRoleVO(acc_VO.getEmployee().getPosition());
		emp_VO.setPosition_name(positionVO.getName());
		List<Employee_ProjectVO> emp_ProVOs = emp_ProDao.getEm_PojectByEmployeeId(employee_Id);
		List<String> project_Names = new ArrayList<>();
		for (Employee_ProjectVO employee_ProjectVO : emp_ProVOs) {
			project_Names.add(employee_ProjectVO.getProject().getName());
		}
		emp_VO.setProjects(project_Names);
		return emp_VO;
	}
}
