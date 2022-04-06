package com.kodluyoruz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class TeacherDto {

    private Long teacherId;

    @NotEmpty(message = "ad soyad alanı bos gecilemez")
    @Size(min = 1, max = 25)
    private String teacherNameSurname;

    @NotEmpty(message = "Email alanı bos gecilemez")
    @Email(message = "Uygun formatta bir mail giriniz")
    private String teacherEmail;

    @NotEmpty(message = "sifre alanı bos gecilemez")
    @Size(min = 3, max = 8)
    private String teacherPassword;
}
