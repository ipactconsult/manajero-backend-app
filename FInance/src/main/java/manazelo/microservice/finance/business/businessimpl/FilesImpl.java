package manazelo.microservice.finance.business.businessimpl;

import manazelo.microservice.finance.business.ibusiness.IFiles;
import manazelo.microservice.finance.entities.FileResponse;
import manazelo.microservice.finance.entities.Files;
import manazelo.microservice.finance.repositories.FilesRep;
import manazelo.microservice.finance.repositories.FilesResponseRep;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service

public class FilesImpl implements IFiles {

    private final FilesRep filesRep;
    private final FilesResponseRep frr;

    @Autowired
    public FilesImpl(@Qualifier("files") FilesRep filesRep, FilesResponseRep frr) {
        this.filesRep =filesRep;
        this.frr = frr;
    }


    @Override
    public List<Files> addFiles(MultipartFile[] multipleFiles, String transactionDetails, Date transactionDate,String uniqueId) throws NullPointerException {
        List <Files> files = new ArrayList<>();


        for (MultipartFile f :multipleFiles) {

            String filename = f.getOriginalFilename();
            if (filename!=null) {
                filename = filename.replaceAll("\\s", "_");


                Files file = new Files();
                try {
                    file.setFile(new Binary(BsonBinarySubType.BINARY, f.getBytes()));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                file.setDifferenciator(uniqueId);
                file.setFileType(f.getContentType());
                file.setTitle(filename);
                file = filesRep.insert(file);
                files.add(file);

                int year =transactionDate.getYear()+1900;
                int month=transactionDate.getMonth()+1;
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(transactionDate);
                int day= calendar.get(Calendar.DAY_OF_MONTH);

                FileResponse response = new FileResponse();
                response.setStringDate(""+year+"-"+""+month+"-"+""+day);

                response.setTitle(filename);
                response.setDate(transactionDate);
                response.setYear(transactionDate.getYear()+1900);
                response.setMonth(transactionDate.getMonth()+1);

                response.setDetails(transactionDetails);
                response.setFileId(file.getId());
                frr.save(response);


            }
            else {
                throw new NullPointerException( "filename cannot be null");
            }
        }

        return files;
    }

    @Override
    public Optional<Files> retrieveFiles(String id) {
       return filesRep.findById(id);

    }

    @Override
    public List<Files> retrieveAllFiles() {
        return filesRep.findAll();
    }





}
