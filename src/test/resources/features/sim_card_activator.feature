Feature: Sim Activation

    Scenario: successfully activate sim
        When the client calls activate-sim api with iccid-1255789453849037777
        Then the client receives success value as true

    Scenario: does not activate sim successfully
        When the client calls activate-sim api with iccid-8944500102198304826
        Then the client receives success value as false
