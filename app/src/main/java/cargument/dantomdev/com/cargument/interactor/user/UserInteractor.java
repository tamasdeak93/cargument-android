package cargument.dantomdev.com.cargument.interactor.user;

import javax.inject.Inject;

import cargument.dantomdev.com.cargument.interactor.conversation.events.GetConversationDetailsEvent;
import cargument.dantomdev.com.cargument.interactor.user.events.GetUserEvent;
import cargument.dantomdev.com.cargument.model.Conversation;
import cargument.dantomdev.com.cargument.model.User;
import cargument.dantomdev.com.cargument.repositoy.Repository;
import de.greenrobot.event.EventBus;

public class UserInteractor {
    @Inject
    Repository repository;
    @Inject
    EventBus bus;

    public void getUser(String userId){
        GetUserEvent event = new GetUserEvent();
        try {
            User user = repository.getUser(userId);
            event.setUser(user);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void saveUser(User user){
        GetUserEvent event = new GetUserEvent();
        try {
            repository.saveUser(user);
            event.setUser(user);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
