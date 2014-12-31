/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.model;

import miage.bean.MessageBean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "message")
public class Message extends Abstract<MessageBean> implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="object")
    private String object;

    @Column(name="content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "to_user", nullable = false)
    private User to;

    @ManyToOne
    @JoinColumn(name = "from_user", nullable = false)
    private User from;

    public Message() {
    }

    public Message(String object, String content, User to, User from) {
        this.object = object;
        this.content = content;
        this.to = to;
        this.from = from;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    @Override
    public void loadFromBean(MessageBean bean) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
