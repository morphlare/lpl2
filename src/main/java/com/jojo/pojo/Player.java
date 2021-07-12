package com.jojo.pojo;

/**
 * @author JOJO
 * @create 2021-06-13-16:20
 */
public class Player {
    private Integer playerId;
    private String playerName;
    private Integer rankId;
    private String sex;
    private Integer age;
    private String role;
    private String password;
    private String rankName;
    private Integer identity;
    private String pic;

    public Player(Integer playerId, String playerName, Integer rankId, String sex, Integer age, String role, String password, Integer identity) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.rankId = rankId;
        this.sex = sex;
        this.age = age;
        this.role = role;
        this.password = password;
        this.identity = identity;
    }

    public Player(Integer playerId, String playerName, Integer rankId, String sex, Integer age, String role, String password, String rankName, Integer identity, String pic) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.rankId = rankId;
        this.sex = sex;
        this.age = age;
        this.role = role;
        this.password = password;
        this.rankName = rankName;
        this.identity = identity;
        this.pic = pic;
    }

    public Player(Integer playerId, String playerName, Integer rankId, String sex, Integer age, String role, String password, String pic) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.rankId = rankId;
        this.sex = sex;
        this.age = age;
        this.role = role;
        this.password = password;
        this.pic = pic;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Player() {
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", playerName='" + playerName + '\'' +
                ", rankId=" + rankId +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                ", rankName='" + rankName + '\'' +
                ", identity=" + identity +
                '}';
    }
}
