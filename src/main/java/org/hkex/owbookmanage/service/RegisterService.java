package org.hkex.owbookmanage.service;

public interface RegisterService {
    boolean auth(String username);

    boolean register(String username, String nickname, String password);
}
