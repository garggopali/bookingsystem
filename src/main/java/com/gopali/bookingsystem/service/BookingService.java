package com.gopali.bookingsystem.service;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gopali.bookingsystem.model.AvailitySlot;
import com.gopali.bookingsystem.model.Booking;
import com.gopali.bookingsystem.model.Coworker;
import com.gopali.bookingsystem.repository.AvailitySlotRepo;
import com.gopali.bookingsystem.repository.BookingRepo;
import com.gopali.bookingsystem.repository.CoworkerRepo;

@Service
public class BookingService {

    @Autowired
    CoworkerRepo coworkerRepo;

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    private AvailitySlotRepo availitySlotRepo;

    public boolean addBooking(Booking booking) {

        // 1. Basic field validations

        if (booking == null)
            throw new IllegalArgumentException(" Please submit the required details");
        else if (!StringUtils.hasText(booking.getCustomerName()))
            throw new IllegalArgumentException("Customer name is missing");
        else if (booking.getDate() == null)
            throw new IllegalArgumentException("Booking date is missing");
        else if (booking.getStartTime() == null)
            throw new IllegalArgumentException("Booking start time is missing");
        else if (booking.getEndTime() == null)
            throw new IllegalArgumentException("Booking end time is missing");
        else if (!booking.getStartTime().isBefore(booking.getEndTime()))
            throw new IllegalArgumentException("Start time should be after end time");

        // 2. Coworker existence check

        Long coworkerId = booking.getCoworkerId();
        if (coworkerId == null)
            throw new IllegalArgumentException("Coworker id should not be null");
        else {
            Coworker coworker = coworkerRepo.findById(coworkerId)
                    .orElseThrow(() -> new IllegalArgumentException("Coworker is not found"));

            LocalDate date = booking.getDate();
            LocalTime startTime = booking.getStartTime();
            LocalTime endTime = booking.getEndTime();

            // 3. Check availability slot

            List<AvailitySlot> slots = availitySlotRepo.findByCoworkerIdAndDate(coworkerId, date);
            boolean isWithinAvailability = slots.stream()
                    .anyMatch(slot -> !slot.getStartTime().isAfter(startTime) && !slot.getEndTime().isBefore(endTime));

            if (!isWithinAvailability) {
                throw new IllegalArgumentException("Booking time is outside coworker's available slots");
            }

            // 4. Check booking overlaps

            List<Booking> existingBookings = bookingRepo.findByCoworkerIdAndDate(coworkerId, date);
            boolean isOverlapping = existingBookings.stream()
                    .anyMatch(b -> !(endTime.isBefore(b.getStartTime()) || startTime.isAfter(b.getEndTime())));

            if (isOverlapping) {
                throw new IllegalArgumentException("Booking time overlaps with an existing booking");
            }

            // 5. Save booking

            bookingRepo.save(booking);
            return true;
        }
    }

 public List<Booking> getBookings(LocalDate date, Long coworkerId) {
    if (date != null && coworkerId != null) {
        return bookingRepo.findByCoworkerIdAndDate(coworkerId, date);
    } else if (date != null) {
        return bookingRepo.findByDate(date);
    } else if (coworkerId != null) {
        return bookingRepo.findByCoworkerId(coworkerId);
    } else {
        return bookingRepo.findAll();
    }
}

    // 1. add db connfig
    // 2. java profiling
    // getting the booking
}