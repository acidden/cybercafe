package project.cybercafe.hardware.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Getter
@Setter
@ToString
@Table(name= "computers")
@SQLDelete(sql = "UPDATE computers SET deleted = true WHERE id = ?")
@SQLRestriction("deleted = false")
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Long pcNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ZoneType zoneType;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private boolean deleted = false;

    public enum Status {
        AVAILABLE,
        OCCUPIED,
        MAINTENANCE
    }

    public enum ZoneType {
        MAIN,
        VIP,
        BOOTCAMP
    }
}
