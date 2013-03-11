package org.vsp.mup.dao;

import java.util.List;

import org.vsp.mup.domain.Role;

public interface RoleDAO {
	public void addRole(Role role);
	public void deleteRole(Role role);
	public List<Role> getUserIdList();
}
