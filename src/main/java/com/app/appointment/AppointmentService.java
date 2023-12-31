package com.app.appointment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppointmentService {

   private AppointmentDb appointmentDb;


    private final AppointmenRepository appointmenRepository;
    @Autowired
    public AppointmentService(AppointmenRepository appointmenRepository){
        this.appointmenRepository=appointmenRepository;
    }

    public boolean creatRequast(AppointmentForm appointmentForm, AppointmentDb appointmentDb) {
       appointmentDb.setApponitmentService(appointmentForm.getService());
       appointmentDb.setApponitmentHour(appointmentForm.getHour());
       appointmentDb.setApponitmentDay(appointmentForm.getDay());
appointmentDb.setAppointmentId(223);

return true;
    }

    public String online() {

        return "Home";
    }
}
