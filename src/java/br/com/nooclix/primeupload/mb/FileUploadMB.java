package br.com.nooclix.primeupload.mb;

import java.io.IOException;
import java.util.Scanner;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name="fileUploadMB")
@ViewScoped
public class FileUploadMB {

    private UploadedFile file;
    public String conteudoDoArquivo;

        public String getConteudoDoArquivo() {
            return conteudoDoArquivo;
        }

        public void setConteudoDoArquivo(String conteudoDoArquivo) {
            this.conteudoDoArquivo = conteudoDoArquivo;
        }    
   
     
    public void handleFileUpload(FileUploadEvent event) throws IOException {
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
     
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        conteudoDoArquivo = new Scanner(event.getFile().getInputstream(),"UTF-8").useDelimiter("\\A").next();
        System.out.println(conteudoDoArquivo);
    }
}

