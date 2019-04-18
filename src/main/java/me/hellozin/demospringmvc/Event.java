package me.hellozin.demospringmvc;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Event {

    interface ValidateName {}
    interface ValidateLimit {}

    private Integer id;

    @NotBlank
    private String name;

    @Min(0)
    private Integer limit;

    private LocalDate startDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
