package miage.bean;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import miage.model.Message;
import miage.model.User;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.File;

/**
 * Created by Maxime on 12/31/2014.
 */
public class MessageBean extends Abstract<Message> {

    private String object;

    private String content;

    private UserBean to;

    private UserBean from;

    private String destinator;

    private String file;

    // File upload
    private File fileUpload;
    private String fileUploadContentType;
    private String fileUploadFileName;

    @Override
    public void loadFromModel(Message model) throws Exception {
        this.object = model.getObject();
        this.content = model.getContent();
        this.to = BeanFactory.create( UserBean.class, model.getTo());
        this.from = BeanFactory.create( UserBean.class, model.getFrom() );
        this.file = model.getFile();
    }

    @RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "object", message="Supply object")
    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    @RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "content", message="Supply a content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserBean getTo() {
        return to;
    }

    public void setTo(UserBean to) {
        this.to = to;
    }

    public UserBean getFrom() {
        return from;
    }

    public void setFrom(UserBean from) {
        this.from = from;
    }

    public String getDestinator() {
        return destinator;
    }

    public File getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(File fileUpload) {
        this.fileUpload = fileUpload;
    }

    public String getFileUploadContentType() {
        return fileUploadContentType;
    }

    public void setFileUploadContentType(String fileUploadContentType) {
        this.fileUploadContentType = fileUploadContentType;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFileUploadFileName() {
        return fileUploadFileName;
    }

    public void setFileUploadFileName(String fileUploadFileName) {
        this.fileUploadFileName = fileUploadFileName;
    }

    @RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "to", message="Choose a destinator")
    public void setDestinator(String destinator) {
        this.destinator = destinator;
    }
}
