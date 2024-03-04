package ru.proj.Wiki.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import ru.proj.Wiki.model.Wiki;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryWikiDAO {
        private final List<Wiki> WIKI = new ArrayList<>();

        public List<Wiki> findAllWiki() {
            return WIKI;
        }

        public Wiki saveWiki(Wiki wiki) {
            WIKI.add(wiki);
            return wiki;
        }

        public Wiki findByRequest(String request) {
            return WIKI.stream()
                    .filter(element -> element.getRequestWiki().equals(request))
                    .findFirst()
                    .orElse(null);
        }

        public Wiki updateStudent(Wiki Wiki) {
            var WikiIndex = IntStream.range(0, WIKI.size())
                    .filter(index -> WIKI.get(index).getRequestWiki().equals(Wiki.getRequestWiki()))
                    .findFirst()
                    .orElse(-1);
            if (WikiIndex > -1) {
                WIKI.set(WikiIndex, Wiki);
                return Wiki;
            }
            return null;
        }

        public void deleteWiki(String request) {
            var student = findByRequest(request);
            if (student != null) {
                WIKI.remove(student);
            }

        }
    }
