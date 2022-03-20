package edu.neu.madcourse.recyclerview;

/**
 * This interface is passed to the recyclerview adapter as an argument and it is implemented in
 * the MainActivity. The purpose of this interface is to enable communication from the adapter to
 * the MainActivity, note that you can send any object as the parameter to the onPersonItemClicked,
 * additionally you can also define multiple methods based on different types of actions that you
 * want to perform.
 */
public interface CallbackInterface {

    /**
     * This method is called everytime an item of the recyclerview is clicked.
     *
     * @param person    the person object on which the user clicked.
     */
    void onPersonItemClicked(Person person);

}
