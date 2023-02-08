package service;

import java.util.function.Predicate;

import com.example.model.User;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public interface Specification <User> {
	public Predicate toPredicate
    (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder);

}
