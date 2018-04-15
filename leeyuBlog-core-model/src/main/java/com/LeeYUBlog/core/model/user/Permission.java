package com.LeeYUBlog.core.model.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;

import com.LeeYUBlog.core.constants.SchemaConstant;
import com.LeeYUBlog.core.model.common.audit.AuditSection;
import com.LeeYUBlog.core.model.common.audit.Auditable;
import com.LeeYUBlog.core.model.generic.LeeYUBlogEntity;

@Entity
@EntityListeners(value = Auditable.class)
@Table(name = "T_PERMISSION", schema = SchemaConstant.LEEYUBLOG_SCHEMA)
public class Permission extends LeeYUBlogEntity<Integer, Role> implements Auditable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9123882012594510512L;
	@Id
	@Column(name = "PERMISSION_ID", unique=true, nullable=false)
	@TableGenerator(name = "TABLE5_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "PERMISSION_SEQ_NEXT_VAL")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE5_GEN")
	private Integer id;
	
	public Permission(){
		
	}
	
	public Permission(String permissionName) {
		this.permissionName = permissionName;
	}
	
	@NotNull
	@Column(name="PERMISSION_NAME", unique=true)
	private String permissionName;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade = {CascadeType.REFRESH})
	@JoinTable(name = "T_ROLE_PERMISSION_XREF", schema=SchemaConstant.LEEYUBLOG_SCHEMA, joinColumns = {
			@JoinColumn(name = "PERMISSION_ID", nullable = false, updatable = false)}
			,
			inverseJoinColumns = { @JoinColumn(name = "ROLE_ID", 
					nullable = false, updatable = false)}
	)
	@Cascade({
		org.hibernate.annotations.CascadeType.DETACH,
		org.hibernate.annotations.CascadeType.LOCK,
		org.hibernate.annotations.CascadeType.REFRESH,
		org.hibernate.annotations.CascadeType.REPLICATE
		
	})
	private List<Role> roles = new ArrayList<Role>();
	
	@Embedded
	private AuditSection auditSection = new AuditSection();
	
	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public AuditSection getAuditSection() {
		return this.auditSection;
	}
	
	@Override
	public void setAuditSection(AuditSection audit) {
		this.auditSection = audit;
	}
	
	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
