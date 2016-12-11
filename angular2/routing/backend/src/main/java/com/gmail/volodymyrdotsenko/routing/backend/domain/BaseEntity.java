package com.gmail.volodymyrdotsenko.routing.backend.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;

@MappedSuperclass
public class BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "DATE_CREATE")
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date dateCreate = new Date();
	@Column(name = "DATE_UPDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;
	@Column(name = "VERSION")
	@Version
	private Integer version;

	@PrePersist
	protected void onCreate() {
		dateCreate = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		dateUpdate = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
