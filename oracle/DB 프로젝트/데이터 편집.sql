update tblScore set student_seq = 900
    where student_seq = 1080;
   
update tblWrittenTest set writtenDate =  '23/04/28'
    where subject_seq = 11 and written_seq between 571 and 660;
    
update tblWrittenTest set writtenScore = 36
    where written_seq in (7, 15, 23, 31, 39, 47, 55, 63, 71, 79, 87, 95, 103, 111, 119, 127, 135, 143, 151, 159, 167, 175, 183, 191, 199, 207, 215, 223, 231); 

update tblWrittenTest set writtenScore = 28
    where written_seq in (235, 243, 251, 259, 267, 275, 283, 291, 299, 307, 315, 323, 331, 339, 347, 355, 363, 371, 379, 387, 395, 403, 411, 419, 427, 435, 443, 451, 459, 467, 475, 483, 491, 499, 507, 515, 523, 531, 539, 547, 555, 563, 571, 579, 587, 595, 603, 611, 619, 627, 635, 643, 651, 659);

 
update tblWrittenTest set writtenScore = 26
    where written_seq in (11, 19, 27, 35, 43, 51, 59, 67, 75, 83, 91, 99, 107, 115, 123, 131, 139, 147, 155, 163, 171, 179, 187, 195, 203);

update tblWrittenTest set writtenScore = 24
    where written_seq in (203, 211, 219, 227, 235, 243, 251, 259, 267, 275, 283, 291, 299, 307, 315, 323, 331, 339, 347, 355, 363, 371, 379, 387, 395);    


update tblWrittenTest set writtenScore = 18
    where written_seq in (403, 411, 419, 427, 435, 443, 451, 459, 467, 475, 483, 491, 499, 507, 515, 523, 531, 539, 547, 555, 563, 571, 579, 587);

    
update tblWrittenTest set writtenScore = null
    where writtenDate = '23/04/28';
    
update tblWrittenTest set writtenScore = null
    where writtenDate = '23/05/29' or writtenDate = '23/04/13';
    

update tblBookSign set signature = null
    where book_seq = 9 and student_seq between 841 and 870;
    
    
update tblPracticalTest set practicalScore = null
    where practicalDate = '23/04/28';