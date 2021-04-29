package someshbose.github.io.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import someshbose.github.io.domain.model.Publisher;
import someshbose.github.io.domain.repo.PublisherRepo;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {

    private PublisherRepo publisherRepo;

    @Autowired
    public PublisherService(PublisherRepo publisherRepo){
        this.publisherRepo=publisherRepo;
    }

    public void getAll(){
        List<Publisher> publisherList = (List<Publisher>) publisherRepo.findAll();
        for (Publisher publisher:publisherList){
            System.out.println(publisher.getId()+"----> "+ publisher.getName());
        }
    }

    public Publisher addPublisher(String name, String date) {
        Publisher publisher = Publisher.builder().name(name).year_of_publication(date).build();
        publisherRepo.save(publisher);

        return publisher;
    }

    public Optional<Publisher> findById(Long id){
        return publisherRepo.findById(id);
    }
}
