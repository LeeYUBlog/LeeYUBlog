package com.LeeYUBlog.core.model.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;

import com.LeeYUBlog.core.constants.SchemaConstant;
import com.LeeYUBlog.core.model.common.audit.AuditSection;
import com.LeeYUBlog.core.model.common.audit.Auditable;
import com.LeeYUBlog.core.model.generic.LeeYUBlogEntity;

@Entity
@EntityListeners(value = Auditable.class)
@Table(name = "T_ROLE", schema = SchemaConstant.LEEYUBLOG_SCHEMA)
public class Role extends LeeYUBlogEntity<Integer, Role> implements Auditable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5577584441927841167L;
	@Id
	@Column(name = "ROLE_ID", unique = true, nullable = false)
	@TableGenerator(name = "TABLE3_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "ROLE_SEQ_NEXT_VAL")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE3_GEN")
	private Integer id;
	
	public Role() {
		
	}
	
	@Column (name = "ROLE_TYPE")
	@Enumerated(value = EnumType.STRING)
	private RoleType roleType;
	
	@Column(name = "ROLE_DESC")
	private String description;
	
	@NotNull
	@Column(name = "ROLE_NAME", unique = true)
	private String roleName;
	
	public Role(String roleName){
		this.roleName = roleName;
	}
	
	@ManyToMany(mappedBy = "roles")
	private Set<Permission> permissions = new HashSet<Permission>();
	
	@Embedded
	private AuditSection auditSection = new AuditSection();
	
	@Override
	public AuditSection getAuditSection() {
		return this.auditSection;
	}

	@Override
	public void setAuditSection(AuditSection audit) {
		this.auditSection = audit;
	}
	
	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public RoleType getRoleType() {
		return roleType;
	}

}
