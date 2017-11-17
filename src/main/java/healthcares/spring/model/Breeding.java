package healthcares.spring.model;
// Generated Aug 3, 2016 3:30:03 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Breeding generated by hbm2java
 */
@Entity
@Table(name = "breeding", catalog = "induct")
public class Breeding implements java.io.Serializable {

	private Integer id;
	private Semen semen;
	private Cattle cattleByCattlefaId;
	private CountBreed countBreed;
	private Member member;
	private Cattle cattleByCattlemaId;
	private String date;
	private String time;
	private String amount;
	private String note;
	private Set<Pregnant> pregnants = new HashSet<Pregnant>(0);

	public Breeding() {
	}

	public Breeding(Semen semen, Cattle cattleByCattlefaId, CountBreed countBreed, Member member,
			Cattle cattleByCattlemaId, String date, String time, String amount, String note, Set<Pregnant> pregnants) {
		this.semen = semen;
		this.cattleByCattlefaId = cattleByCattlefaId;
		this.countBreed = countBreed;
		this.member = member;
		this.cattleByCattlemaId = cattleByCattlemaId;
		this.date = date;
		this.time = time;
		this.amount = amount;
		this.note = note;
		this.pregnants = pregnants;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "semen_id")
	public Semen getSemen() {
		return this.semen;
	}

	public void setSemen(Semen semen) {
		this.semen = semen;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cattlefa_id")
	public Cattle getCattleByCattlefaId() {
		return this.cattleByCattlefaId;
	}

	public void setCattleByCattlefaId(Cattle cattleByCattlefaId) {
		this.cattleByCattlefaId = cattleByCattlefaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "count_breed_id")
	public CountBreed getCountBreed() {
		return this.countBreed;
	}

	public void setCountBreed(CountBreed countBreed) {
		this.countBreed = countBreed;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cattlema_id")
	public Cattle getCattleByCattlemaId() {
		return this.cattleByCattlemaId;
	}

	public void setCattleByCattlemaId(Cattle cattleByCattlemaId) {
		this.cattleByCattlemaId = cattleByCattlemaId;
	}


	@Column(name = "date", length = 10)
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	@Column(name = "time", length = 8)
	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Column(name = "amount", length = 45)
	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Column(name = "note", length = 500)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "breeding")
	public Set<Pregnant> getPregnants() {
		return this.pregnants;
	}

	public void setPregnants(Set<Pregnant> pregnants) {
		this.pregnants = pregnants;
	}

}