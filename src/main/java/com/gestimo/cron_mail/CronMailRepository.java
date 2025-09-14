package com.gestimo.cron_mail;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CronMailRepository extends JpaRepository<CronMail, Long> {
}