package manazelo.microservice.finance.business.businessimpl;

import manazelo.microservice.finance.business.ibusiness.IFilesResponse;
import manazelo.microservice.finance.entities.FileResponse;
import manazelo.microservice.finance.repositories.FilesRep;
import manazelo.microservice.finance.repositories.FilesResponseRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilesResponseImpl implements IFilesResponse {

    private final FilesResponseRep frr;
    private final FilesRep fr;
    @Autowired
    public FilesResponseImpl(FilesResponseRep frr, FilesRep fr) {
        this.frr = frr;
        this.fr = fr;
    }
    @Override
    public List<FileResponse> retrieveAllFileResponse() {
        return frr.findAll();
    }

    @Override
    public List<FileResponse> retrieveFileResponseByMonthAndYear(int month, int year) {
        return frr.findFileResponseByMonthAndYear(month,year);
    }

    @Override
    public FileResponse reconcileFile(FileResponse fr) {
        fr.setReconciled(Boolean.TRUE);
        frr.save(fr);
        return fr;
    }

    @Override
    public FileResponse deleteFileResponse(String id) {

        FileResponse fre =frr.findById(id).orElse(null);
        frr.deleteById(id);
        assert fre != null;
        String fileId =fre.getFileId();
        fr.deleteById(fileId);


        return fre;
    }


}
