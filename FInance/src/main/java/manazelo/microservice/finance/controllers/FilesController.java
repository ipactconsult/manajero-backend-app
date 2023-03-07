package manazelo.microservice.finance.controllers;
import manazelo.microservice.finance.business.businessimpl.FilesImpl;
import manazelo.microservice.finance.business.businessimpl.FilesResponseImpl;
import manazelo.microservice.finance.entities.FileResponse;
import manazelo.microservice.finance.entities.Files;
import manazelo.microservice.finance.repositories.FilesRep;
import manazelo.microservice.finance.repositories.FilesResponseRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.*;

@CrossOrigin
@Controller
public class FilesController {

    private final FilesImpl fs;
    private final FilesResponseImpl fri;
    private final FilesResponseRep frr;
    private final FilesRep fr;

    @Autowired
    public FilesController(FilesImpl fs, FilesResponseImpl fri, FilesResponseRep frr, FilesRep fr) {
        this.fs = fs;
        this.fri = fri;
        this.frr = frr;
        this.fr = fr;
    }


    @PostMapping("/files/add")
    public ResponseEntity<List<Files>> addFile(@RequestParam("files") MultipartFile[] multipleFiles, @RequestParam("date") Date transactionDate, @RequestParam("details") String transactionDetails, @RequestParam("uniqueId") String uniqueId)  {
       List<Files> files = fs.addFiles(multipleFiles,transactionDetails,transactionDate,uniqueId);
        return new ResponseEntity<>(files, HttpStatus.CREATED);


    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) throws NullPointerException {
        Files fileDB = fr.findById(id).orElse(null);

        if (fileDB != null)
        {
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(fileDB.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getTitle() + "\"")
                .body(fileDB.getFile().getData())
                ;}
        else {
            throw new NullPointerException("file not found");
        }

    }


   @GetMapping("/FilesResponses/byMonthAndYear/{month}/{year}")
   public ResponseEntity<List<FileResponse>> getResponsesByMandY (@PathVariable int month , @PathVariable int year) {
        List<FileResponse> responses= fri.retrieveFileResponseByMonthAndYear(month,year);
        return new ResponseEntity<>(responses,HttpStatus.OK);
   }
    @GetMapping("/FilesResponses/byDateAndDetails/{date}/{details}")
    public ResponseEntity<List<FileResponse>> getResponsesByMandY (@PathVariable String date , @PathVariable  String details) {
        List<FileResponse> responses= frr.findFilesByDateAndDetails(date, details);
        return new ResponseEntity<>(responses,HttpStatus.OK);
    }


    @GetMapping("files/Allfiles")
    @ResponseBody
    public ResponseEntity<List<Files>> getFiles () {
        List<Files> files= fs.retrieveAllFiles();
        return new ResponseEntity<>(files,HttpStatus.OK);
    }
    @GetMapping("files/AllFilesResponse")
    @ResponseBody
    public ResponseEntity<List<FileResponse>> getFilesResponse () {
        List<FileResponse> files= fri.retrieveAllFileResponse();

        return new ResponseEntity<>(files,HttpStatus.OK);
    }
    @GetMapping("files/reconciledFiles")
    @ResponseBody
    public ResponseEntity<List<FileResponse>> getReconciledFiles () {
        List<FileResponse> files= frr.findReconciledFiles();
        return new ResponseEntity<>(files,HttpStatus.OK);
    }
    @GetMapping("files/nonReconciledFiles")
    @ResponseBody
    public ResponseEntity<List<FileResponse>> getNonReconciledFiles () {
        List<FileResponse> files= frr.findnonReconciledFiles();

        return new ResponseEntity<>(files,HttpStatus.OK);
    }

    @PutMapping("/files/reconcileFile")
    @ResponseBody
    public ResponseEntity<FileResponse> reconcileFile(@RequestBody FileResponse fr) {
        FileResponse reconciled = fri.reconcileFile(fr);
        return new ResponseEntity<>(reconciled,HttpStatus.OK);
    }
    @DeleteMapping("/files/removeFileResponse/{id}")
    @ResponseBody
    public ResponseEntity<String> removeFileResponse(@PathVariable("id") String id) {
        fri.deleteFileResponse(id);
        return new ResponseEntity<>("transaction deleted",HttpStatus.OK);
    }



}
