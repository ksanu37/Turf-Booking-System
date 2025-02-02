import com.turf.dto.AddUserRequest;
import com.turf.dto.BookingRequest;
import com.turf.entities.*;
import com.turf.factory.UserFactory;
import com.turf.repositories.SlotRepo;
import com.turf.repositories.impl.BookingRepoImpl;
import com.turf.repositories.impl.SlotRepoImpl;
import com.turf.repositories.impl.TurfRepoImpl;
import com.turf.repositories.impl.UserRepoImpl;
import com.turf.services.IBookingService;
import com.turf.services.ISlotService;
import com.turf.services.ITurfService;
import com.turf.services.IUserService;
import com.turf.services.impl.BookingServiceImpl;
import com.turf.services.impl.SlotServiceImpl;
import com.turf.services.impl.TurfServiceImpl;
import com.turf.services.impl.UserServiceImpl;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        IUserService userService = new UserServiceImpl(new UserFactory(), UserRepoImpl.getInstance());
        ITurfService turfService = new TurfServiceImpl(userService, TurfRepoImpl.getInstance(), SlotRepoImpl.getInstance());
        ISlotService slotService = new SlotServiceImpl(SlotRepoImpl.getInstance());
        IBookingService bookingService = new BookingServiceImpl(BookingRepoImpl.getInstance(), turfService, userService, slotService);
        AbstractUser addedUser = userService.addUser(new AddUserRequest("Sanu", "9631981572", "ADMIN"));
        System.out.println(addedUser.getId() + " " + addedUser);

        Turf turf = new Turf("HSR Layout", addedUser.getId(), "Bengaluru", List.of(GameType.BADMINTON, GameType.CRICKET));
        turfService.addTurf(turf, "abcd");
        turfService.addTurf(turf, addedUser.getId());
        // Adding a slot
        List<Slot> slotList = new ArrayList<>();
        slotList.add(new Slot(OffsetDateTime.now(), OffsetDateTime.now().plusHours(2), turf.getId(), GameType.BADMINTON));
        slotList.add(new Slot(OffsetDateTime.now().plusHours(2), OffsetDateTime.now().plusHours(4), turf.getId(), GameType.BADMINTON));
        slotList.add(new Slot(OffsetDateTime.now().plusHours(4), OffsetDateTime.now().plusHours(6), turf.getId(), GameType.CRICKET));
        turfService.addSlots(addedUser.getId(), turf.getId(), slotList);

        System.out.println(turfService.getAllFutureSlotsForTurfId(turf.getId()));

        AbstractUser customer = userService.addUser(new AddUserRequest("Shivam", "9631981572", "CUSTOMER"));
        System.out.println("Making booking for customer id :: "  + customer.getId() + " slotId :: " + slotList.get(0).getId());
        Booking booking = bookingService.initiateBooking(new BookingRequest(slotList.get(0).getId(), customer.getId()));
        System.out.println(booking);

        System.out.println("Booked slot status = " + slotService.getSlotById(booking.getSlotId()));
        bookingService.initiateBooking(new BookingRequest(slotList.get(0).getId(), customer.getId()));


    }
}