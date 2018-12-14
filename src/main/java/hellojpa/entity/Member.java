package hellojpa.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(indexes = @Index(name = "name_idx01", columnList = "id,name"))
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MEMBER")
    @SequenceGenerator(name = "SEQ_MEMBER", sequenceName = "SEQ_NAME", allocationSize = 100)    // 키 전략 최적화 방법
    private Long id;
    @Column(length = 20, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;

    @ManyToOne
    private Team team;

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }
}
