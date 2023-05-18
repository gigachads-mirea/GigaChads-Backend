package ru.gigachads.service;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import ru.gigachads.entity.Server;
import ru.gigachads.repository.ServerRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ServerService {
    private final ServerRepository serverRepository;
    private final EntityManager entityManager;

    public List<Server> getAll() { return serverRepository.findAll(); }

    @Nullable
    public Server getOne(Long id) {
        Server server = null;

        try { server = serverRepository.getById(id); }
        catch (EntityNotFoundException ignored) {}

        return server;
    }

    public boolean deleteOne(Long id) {
        try {
            serverRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    @Nullable
    private static Object stringValueToType(Class<?> type, String value) {
        val typeName = type.getTypeName();

        if (typeName.equals(int.class.getTypeName()))
            return Integer.valueOf(value);
        if (typeName.equals(String.class.getTypeName()))
            return value;
        if (typeName.equals(float.class.getTypeName()))
            return Float.valueOf(value);
        if (typeName.equals(boolean.class.getTypeName()))
            return Boolean.valueOf(value);
        if (typeName.equals(long.class.getTypeName()))
            return Long.valueOf(value);

        return null;
    }

    public List<Server> getFiltered(String fieldName, String value) {
        val resultList = new ArrayList<Server>();

        for (val field : Server.class.getDeclaredFields()) {
            if (!fieldName.equals(field.getName())) continue;

            val criteriaBuilder = entityManager.getCriteriaBuilder();
            val query = criteriaBuilder.createQuery();
            val server = query.from(Server.class);

            query.where(criteriaBuilder.equal(
                server.get(fieldName),
                stringValueToType(field.getType(), value)
            ));

            entityManager.createQuery(query)
                .getResultList()
                .forEach(object -> {
                    if (object != null)
                        resultList.add((Server) object);
                });

            break;
        }

        return resultList;
    }
}
