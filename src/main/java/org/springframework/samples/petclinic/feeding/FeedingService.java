package org.springframework.samples.petclinic.feeding;

import java.util.List;

import javax.persistence.RollbackException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FeedingService {

    private FeedingRepository feedingRepository;

    @Autowired
    public FeedingService(FeedingRepository feedingRepository) {
        this.feedingRepository = feedingRepository;
    }

    public List<Feeding> getAll(){
        return feedingRepository.findAll();
    }

    public List<FeedingType> getAllFeedingTypes(){
        return null;
    }

    public FeedingType getFeedingType(String typeName) {
        return feedingRepository.findFeedingType(typeName);
    }

    @Transactional(rollbackFor = UnfeasibleFeedingException.class)
	public Feeding save(Feeding p) throws UnfeasibleFeedingException {
        if(p.pet.getType().equals(feedingRepository.findFeedingTypeById(p.getFeedingType().getId()).getPetType())){
            feedingRepository.save(p);
            return p; 
        } else{
            throw new UnfeasibleFeedingException();
        }               
	}

    
}
