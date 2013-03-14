package com.fengtuo.healthcare.repository;

import com.fengtuo.healthcare.model.Packet;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2/21/13
 * Time: 9:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class PacketRepository {

    private WaveRecordRepository waveRecordRepository;

    private UserRepository userRepository;

    private DigitRecordRepository digitRecordRepository;

    public PacketRepository() {
    }

    public PacketRepository(DigitRecordRepository digitRecordRepository,
                            WaveRecordRepository waveRecordRepository,
                            UserRepository userRepository) {
        this.digitRecordRepository = digitRecordRepository;
        this.waveRecordRepository = waveRecordRepository;
        this.userRepository = userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setWaveRecordRepository(WaveRecordRepository waveRecordRepository) {
        this.waveRecordRepository = waveRecordRepository;
    }

    public void setDigitRecordRepository(DigitRecordRepository digitRecordRepository) {
        this.digitRecordRepository = digitRecordRepository;
    }

    public void save(Packet packet){
        packet.initRecordUser(userRepository.findUser(packet.getDeviceId()));
        digitRecordRepository.insert(packet.getDigitRecords());
        waveRecordRepository.insert(packet.getWaveRecords());
    }
}
