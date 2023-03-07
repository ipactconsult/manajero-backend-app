package manazelo.microservice.finance.business.ibusiness;

import manazelo.microservice.finance.entities.FileResponse;
import manazelo.microservice.finance.entities.Files;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IFilesResponse {
    List<FileResponse> retrieveAllFileResponse ();
    List<FileResponse> retrieveFileResponseByMonthAndYear (int month, int year);
    FileResponse reconcileFile ( FileResponse fr);
    FileResponse deleteFileResponse(String id );
}
