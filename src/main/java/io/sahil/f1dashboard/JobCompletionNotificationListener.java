package io.sahil.f1dashboard;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.sahil.f1dashboard.Model.Circuit;
import io.sahil.f1dashboard.Model.Constructors;
import io.sahil.f1dashboard.Model.Driver;
import io.sahil.f1dashboard.Model.Race;
import io.sahil.f1dashboard.Model.Result;
import io.sahil.f1dashboard.Model.Status;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

  private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

  private final EntityManager em;

  @Autowired
  public JobCompletionNotificationListener(EntityManager em) {
	  this.em = em;
  }

  @Override
  @Transactional
  public void afterJob(JobExecution jobExecution) {
    if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
      log.info("!!! JOB FINISHED! Time to verify the results");
      
      
      em.createQuery("select r from Result r", Result.class)
      .getResultList()
      .stream()
      .forEach(r -> em.persist(r));
      
      
      em.createQuery("select c from Constructors c", Constructors.class)
      .getResultList()
      .stream()
      .forEach(c -> em.persist(c));
      
      
      em.createQuery("select c from Circuit c", Circuit.class)
      .getResultList()
      .stream()
      .forEach(c -> em.persist(c));
      
      
      em.createQuery("select c from Driver c", Driver.class)
      .getResultList()
      .stream()
      .forEach(c -> em.persist(c));
      
      
      em.createQuery("select c from Race c", Race.class)
      .getResultList()
      .stream()
      .forEach(c -> em.persist(c));
      
      
      em.createQuery("select c from Status c", Status.class)
      .getResultList()
      .stream()
      .forEach(c -> em.persist(c));
      
      
      
      
      
      
    }
  }
}