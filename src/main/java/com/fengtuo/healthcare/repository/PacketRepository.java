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
    private DigitRecordRepository digitRecordRepository;

    public WaveRecordRepository getWaveRecordRepository() {
        return waveRecordRepository;
    }

    public void setWaveRecordRepository(WaveRecordRepository waveRecordRepository) {
        this.waveRecordRepository = waveRecordRepository;
    }

    public DigitRecordRepository getDigitRecordRepository() {
        return digitRecordRepository;
    }

    public void setDigitRecordRepository(DigitRecordRepository digitRecordRepository) {
        this.digitRecordRepository = digitRecordRepository;
    }

    private WaveRecordRepository waveRecordRepository;

    public PacketRepository(DigitRecordRepository digitRecordRepository, WaveRecordRepository waveRecordRepository) {
        this.digitRecordRepository = digitRecordRepository;
        this.waveRecordRepository = waveRecordRepository;
    }

    public PacketRepository() {
    }

    public void save(Packet packet){
        digitRecordRepository.insert(packet.getDigitRecords());
        waveRecordRepository.insert(packet.getWaveRecords());
    }
}
