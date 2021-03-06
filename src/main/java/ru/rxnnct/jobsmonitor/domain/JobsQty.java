package ru.rxnnct.jobsmonitor.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Number of vacancies for a specific request.
 */

@Entity
@Table(name = "jobs_qty")
@Data
public class JobsQty implements Comparable<JobsQty>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "qty")
    private Long qty;
    @Column(name = "record_date_time", updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime recordDateTime;

    public JobsQty() {
    }

    public JobsQty(String name, Long qty) {
        this.name = name;
        this.qty = qty;
        this.setRecordDateTime(LocalDateTime.now());
    }

    @Override
    public int compareTo(JobsQty otherJobsQty) {
        return Long.compare(getId(), otherJobsQty.getId());
    }
}
