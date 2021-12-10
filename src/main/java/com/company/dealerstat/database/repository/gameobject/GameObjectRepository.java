package com.company.dealerstat.database.repository.gameobject;

import com.company.dealerstat.entity.gameObject.GameObject;

import java.util.List;

public interface GameObjectRepository {

    List<GameObject> getAllGameObjects();

    List<GameObject> getGameObjectsFromPost(int postId);

    List<GameObject> getGameObjectsOfGame(int gameId);

    GameObject getGameObject(int objectId);

    void addGameObject(GameObject gameObject);

    void addGameObjectToPost(int gameObjectId, int postId);

    void deleteGameObjectFromPost(int gameObjectId, int postId);
}