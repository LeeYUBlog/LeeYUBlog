package com.LeeYUBlog.core.model.user;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;

import com.LeeYUBlog.core.constants.SchemaConstant;
import com.LeeYUBlog.core.model.common.audit.AuditListener;
import com.LeeYUBlog.core.model.common.audit.AuditSection;
import com.LeeYUBlog.core.model.common.audit.Auditable;
import com.LeeYUBlog.core.model.generic.LeeYUBlogEntity;

@Entity
@EntityListeners(value = AuditListener.class)
@Table(name = "T_USER", schema=SchemaConstant.LEEYUBLOG_SCHEMA)
public class User extends LeeYUBlogEntity<Long, User> implements Auditable{

	/**
	 * User实体 generated ID created by Huinan LUO
	 */
	private static final long serialVersionUID = -7977950248083047459L;
	
	@Id
	@Column(name = "USER_ID", unique=true, nullable=false)
	@TableGenerator(name = "TABLE4_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "USER_SEQ_NEXT_VAL")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE4_GEN")
	private Long id;
	
	public User(){
		
	}
	
	public User(String userName, String password){
		
		this.adminName = userName;
		this.adminPassword = password;
	}
	
	@NotNull
	@Column(name = "ADMIN_NAME", length=100, unique=true)
	private String adminName;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
	@JoinTable(name = "T_USER_ROLE_XREF", schema=SchemaConstant.LEEYUBLOG_SCHEMA, joinColumns = {
			@JoinColumn(name = "USER_ID", nullable = false, updatable = false)}
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
	
	@NotNull
	@Column(name = "ADMIN_PASSWORD", length = 60)
	private String adminPassword;
	
	@Column(name="ACTIVE")
	private boolean active = true;
	
	@Embedded
	private AuditSection auditSection = new AuditSection();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_ACCESS")
	private Date lastAccess;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LOGIN_ACCESS")
	private Date loginTime;
	
	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
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

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isActive() {
		return active;
	}

	public Date getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
}
