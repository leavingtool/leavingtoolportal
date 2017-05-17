package com.dynagility.leavingtoolportal.model.mapper;

import com.dynagility.leavingtoolportal.VO.PositionVO;
import com.dynagility.leavingtoolportal.model.Position;

public class PositionMapper {
	public static PositionVO updateRoleVO(Position position) {
		PositionVO positionVo = new PositionVO();
		positionVo.setId(position.getId() != null ? position.getId() : positionVo.getId());
		positionVo.setName(position.getName() != null ? position.getName() : positionVo.getName());
        return positionVo;
    }
	
	public static Position updateRole(PositionVO positionVO) {
		Position position = new Position();
		position.setId(positionVO.getId() != null ? positionVO.getId() : position.getId());
		position.setName(positionVO.getName() != null ? positionVO.getName() : position.getName());
        return position;
    }

}
