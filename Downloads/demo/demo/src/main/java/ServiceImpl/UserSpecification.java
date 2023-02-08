package ServiceImpl;

import java.util.function.Predicate;

import com.example.model.SearchCriteria;
import com.example.model.User;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import service.Specification;

public class UserSpecification implements Specification<User>{
	private SearchCriteria criteria;
	
	
	@Override
	public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder builder) {
		// TODO Auto-generated method stub
		if (criteria.getOperation().equalsIgnoreCase(">")) {
            return (Predicate) builder.greaterThanOrEqualTo(
              root.<String> get(criteria.getKey()), criteria.getValue().toString());
        } 
        else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return (Predicate) builder.lessThanOrEqualTo(
              root.<String> get(criteria.getKey()), criteria.getValue().toString());
        } 
        else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return (Predicate) builder.like(
                  root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
            } else {
                return (Predicate) builder.equal(root.get(criteria.getKey()), criteria.getValue());
            }
        }
        return null;
	}

}
