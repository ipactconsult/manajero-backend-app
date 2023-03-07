package ipact.manazello.accounting.business.businessimpl;

import ipact.manazello.accounting.business.ibusiness.IFilesProofBusiness;
import ipact.manazello.accounting.model.FilesProof;
import ipact.manazello.accounting.repository.FilesProofRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FilesProofBusinessImpl implements IFilesProofBusiness {

    @Autowired
    private final FilesProofRepository filesProofRepository;

    public FilesProofBusinessImpl(FilesProofRepository filesProofRepository) {
        this.filesProofRepository = filesProofRepository;
    }

    @Override
    public String addFilesProof(String title, MultipartFile file) throws IOException  {
        FilesProof filesProof = new FilesProof(title);
        filesProof.setImage(
                new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        filesProof = filesProofRepository.insert(filesProof); return filesProof.getId();
    }

    @Override
    public FilesProof getFilesProof(String id) {
        return filesProofRepository.findById(id).get();
    }

    @Override
    public List<FilesProof> getAllFilesProof(){
        return filesProofRepository.findAll();
    }
}
