package com.seasonalworkers.workers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.seasonalworkers.workers.entity.WorkerEntity;
import com.seasonalworkers.workers.repository.WorkerRepository;

@Service
public class WorkerService {

    @Autowired
    private final WorkerRepository repository;

    public WorkerService(WorkerRepository repository) {
        this.repository = repository;
    }

    public WorkerEntity create(WorkerEntity worker) {
        return repository.save(worker);
    }

    public WorkerEntity getById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Worker not found"));
    }

    // public List<WorkerEntity> getAll() {
    // return repository.findAll().orElseThrow(
    // () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Workers not
    // found"));
    // }
}