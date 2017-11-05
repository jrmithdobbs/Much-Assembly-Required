package net.simon987.server.webserver;

import net.simon987.server.GameServer;
import org.java_websocket.WebSocket;

import java.util.ArrayList;

public class OnlineUserManager {

    /**
     * List of online users.
     */
    private ArrayList<OnlineUser> onlineUsers = new ArrayList<>(10);


    public OnlineUser getUser(WebSocket socket) {

        ArrayList<OnlineUser> _onlineUsers = new ArrayList<>(onlineUsers);

        for (OnlineUser user : _onlineUsers) {
            if (user.getWebSocket().equals(socket)) {
                return user;
            }
        }

        return null;
    }

    /**
     * Add an user to the list
     *
     * @param user user to add
     */
    public void add(OnlineUser user) {
        onlineUsers.add(user);
    }

    /**
     * Remove an user to the list
     *
     * @param user user to remove
     */
    public void remove(OnlineUser user) {
        onlineUsers.remove(user);
        GameServer.INSTANCE.getGameUniverse().removeUser(user.getUser());
    }

    public ArrayList<OnlineUser> getOnlineUsers() {
        return onlineUsers;
    }
}
