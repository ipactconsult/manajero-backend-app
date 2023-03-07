package manazelo.microservice.finance.business.ibusiness;

import manazelo.microservice.finance.entities.FileResponse;
import manazelo.microservice.finance.entities.Files;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface IFiles {
 List<Files> addFiles (MultipartFile [] multipleFiles, String transactionDetails, Date transactionDate, String uniqueId) ;
 Optional<Files> retrieveFiles (String id);
 List<Files> retrieveAllFiles();
 //Optional<Files> retrieveFileByTitle(String title);



}
