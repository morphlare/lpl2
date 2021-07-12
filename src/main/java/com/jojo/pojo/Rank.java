package com.jojo.pojo;

import java.util.List;

/**
 * @author JOJO
 * @create 2021-06-13-16:21
 */
public class Rank {
    private Integer rankId;
    private String rankName;
    private boolean isChampion;
    private String address;
    private List<Player> playerList;

    public Rank() {
    }

    public Rank(Integer rankId, String rankName, boolean isChampion, String address, List<Player> playerList) {
        this.rankId = rankId;
        this.rankName = rankName;
        this.isChampion = isChampion;
        this.address = address;
        this.playerList = playerList;
    }

    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public boolean isChampion() {
        return isChampion;
    }

    public boolean getIsChampion(){
        return isChampion();
    }

    public void setChampion(boolean champion) {
        isChampion = champion;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "rankId=" + rankId +
                ", rankName='" + rankName + '\'' +
                ", isChampion=" + isChampion +
                ", address='" + address + '\'' +
                ", playerList=" + playerList +
                '}';
    }
}