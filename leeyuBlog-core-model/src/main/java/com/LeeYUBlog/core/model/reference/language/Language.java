package com.LeeYUBlog.core.model.reference.language;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.LeeYUBlog.core.constants.SchemaConstant;
import com.LeeYUBlog.core.model.common.audit.AuditListener;
import com.LeeYUBlog.core.model.common.audit.AuditSection;
import com.LeeYUBlog.core.model.common.audit.Auditable;
import com.LeeYUBlog.core.model.generic.LeeYUBlogEntity;

@Entity
@EntityListeners(value = AuditListener.class)
@Table(name = "LANGUAGE", schema=SchemaConstant.LEEYUBLOG_SCHEMA)
public class Language extends LeeYUBlogEntity<Integer, Language> implements Auditable {

	private static final long serialVersionUID = -7573846480366784058L;
	
	@Id
	@Column(name="LANGUAGE_ID")
	@TableGenerator(name = "TABLE1_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
	pkColumnValue = "LANG_SEQ_NEXT_VAL")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE1_GEN")
	private Integer id;
	
	@Embedded
	private AuditSection auditSection = new AuditSection();
	
	@Column(name="CODE", nullable = false)
	private String code;
	
	@Column(name="SORT_ORDER")
	private Integer sortOrder;
	
	public Language() {
	}
	
	public Language(String code) {
		this.setCode(code);
	}
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	
	@Override
	public AuditSection getAuditSection() {
		return auditSection;
	}

	@Override
	public void setAuditSection(AuditSection auditSection) {
		this.auditSection = auditSection;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof Language)) {
			return false;
		} else {
			Language language = (Language) obj;
			return (this.id == language.getId());
		}
	}
}
