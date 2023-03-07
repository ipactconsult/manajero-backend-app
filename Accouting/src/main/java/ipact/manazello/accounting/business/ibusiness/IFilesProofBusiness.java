package ipact.manazello.accounting.business.ibusiness;

import ipact.manazello.accounting.model.FilesProof;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IFilesProofBusiness {
    String addFilesProof(String title, MultipartFile file) throws IOException;
    FilesProof getFilesProof(String id);
    List<FilesProof> getAllFilesProof();
}
