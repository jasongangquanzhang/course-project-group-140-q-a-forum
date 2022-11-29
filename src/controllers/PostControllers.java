package controllers;
import exceptions.EmptyEntryException;
import use_cases.LoginUseCaseInteractor;
import use_cases.PostUseCaseInteractor;
import use_cases.UserUseCaseInteractor;

import java.util.HashMap;

public class PostControllers {

    private final PostUseCaseInteractor postUseCaseInteractor;
    public PostControllers(PostUseCaseInteractor postUseCaseInteractor){
        this.postUseCaseInteractor = postUseCaseInteractor;
    }

    /**
     * pass all post data from UI.
     * Get the return of CreatePost and justify if get False, return "meaningless post".
     * else, return "successfully post".
     * @param post information will be stored at the HashMap
     * @return  String for each state.
     */
    public int createPost(HashMap<String,Object> post){
        try{
            postUseCaseInteractor.createPost(post);
        }
        catch (EmptyEntryException e){
            return -1;
        }
        return 0;
    }

    /**
     * pass all post data from UI.
     * Get the return of EditPost and justify if get False, return "meaningless post".
     * else, return "successfully post"
     * @param post information will be stored at the HashMap
     * @return  String for each state.
     */
    public int editPost(HashMap<String, Object> post) {
        try{
            postUseCaseInteractor.editPost(post);
        }
        catch(EmptyEntryException e){
            return -1;
        }
        return 0;
    }

    public int removePost(HashMap<String, Object> post){
        try{
            postUseCaseInteractor.removePost(post);
        }
        catch(EmptyEntryException e){
            return -1;
        }
        return 0;
    }
}
