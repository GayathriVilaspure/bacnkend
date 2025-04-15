package org.wtt.solarapp.solar_app.Controller;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.wtt.solarapp.solar_app.Entity.User;
import org.wtt.solarapp.solar_app.Service.UserService;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200") // Allow Angular dev server
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<User> saveUser(
            @RequestParam("name") String name,
            @RequestParam("address") String address,
            @RequestParam("mobileNumber") Long mobileNumber,
            @RequestParam("solarCapacity") Long solarCapacity,
            @RequestParam("paymentMode") String paymentMode,
            @RequestParam("aadharCardFilepath") MultipartFile aadharFile,
            @RequestParam("panCardFilePath") MultipartFile panFile,
            @RequestParam("bankDetailsUpload") MultipartFile bankFile
    ) {
        try {
            User user = new User(
                    name,
                    address,
                    mobileNumber,
                    solarCapacity,
                    paymentMode,
                    aadharFile.getBytes(),
                    panFile.getBytes(),
                    bankFile.getBytes()
            );

            User saved = userService.saveUser(user);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }
    

    @GetMapping
    public ResponseEntity<List<Map<String,Object>>> getAllUsers() {
 
    	
    	      return new ResponseEntity<>(userService.getAllUsersWithImages(), HttpStatus.OK);
    }
    
    
 /*   @GetMapping("/{id}")
    public ResponseEntity<byte[]> downloadUserFile(@PathVariable Long id,@PathVariable String fileType){
    	Optional<User> userOptional = userService.getUser(id);
    	if(userOptional.isPresent()) {
    		User user = userOptional.get();
    		byte[] fileData = new byte[0];
    		String fileName="";
    		switch(fileType.toLowerCase()) {
    		case "adhar":
    			fileData =user.getAadharCardFile();
    			fileName = "adhar.pdf";
    		break;
    		case "pan":
    			fileData = user.getPanCardFile();
    			fileName = "pan.pdf";
    			break;
    			
    		 case  "bank":
    			fileData = user.getBankDetailsFile();
    			fileName = "bank.pdf";
    	
    		}
    	return ResponseEntity.ok()
    			 .header("Content-Disposition", "attachment; filename=" + fileName)
                 .header("Content-Type", "application/pdf")
                 .body(fileData);
    	
}else {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
}
}*/
}