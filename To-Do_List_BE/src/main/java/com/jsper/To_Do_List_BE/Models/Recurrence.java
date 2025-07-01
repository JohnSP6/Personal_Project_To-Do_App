package com.jsper.To_Do_List_BE.Models;

import lombok.Data;

import java.time.*;

@Data
public class Recurrence {

    private String interval;
    private LocalDate nextDueDate;
    private LocalDate repeatUntil;

}
