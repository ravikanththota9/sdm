package com.sdm.utils;

import com.sdm.dto.ClientAccountDevicesResponseDTO;
import com.sdm.dto.DeviceResponseDTO;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AutomationResponse {

    public void writeOutput(List<ClientAccountDevicesResponseDTO> clientAccountDevicesResponseDTOList){
        List<ClientAccountDevicesResponseDTO> successAccountList = new ArrayList<>();
        List<ClientAccountDevicesResponseDTO> failedAccountList = new ArrayList<>();
        for(ClientAccountDevicesResponseDTO clientAccountDevicesResponseDTO : clientAccountDevicesResponseDTOList) {
            if(clientAccountDevicesResponseDTO.getDeviceResponseDTOList() !=null && clientAccountDevicesResponseDTO.getDeviceResponseDTOList().size()>0) {
                successAccountList.add(clientAccountDevicesResponseDTO);
            } else {
                failedAccountList.add(clientAccountDevicesResponseDTO);
            }
        }

        StringBuffer sb = new StringBuffer();
        sb.append("<!DOCTYPE HTML>\n" +
                "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\" name=\"viewport\" content=\"width=device-width, initial-scale=1\" http-equiv=\"X-UA-Conpatible\" />\n" +
                "\t<link rel=\"stylesheet\" href=\"bootstrap.min.css\"> \n" +
                "    <title>Alexa Devices Account Status</title>\n" +
                "    <style type=\"text/css\">\n" +
                "        .tableUpdated {\n" +
                "        \twidth: 90% !important;\n" +
                "        \tmargin: 17px 58px 0 !important;\n" +
                "        }\n" +
                "        .btnSpace {\n" +
                "        \tmargin: 17px;\n" +
                "        }     \n" +
                "    </style>\n" +
                "<head>\n" +
                "<body>\n" +
                "<hr/>");

        sb.append("<h2> Success Accounts (");
        sb.append(successAccountList.size());
        sb.append(" )</h2>");
        for(ClientAccountDevicesResponseDTO clientAccountDevicesResponseDTO : successAccountList) {

            sb.append("<h3>");
            sb.append(clientAccountDevicesResponseDTO.getUserName());
            sb.append("</h3>");
            sb.append("<table class=\"table table-striped table-bordered tableUpdated\">");
            sb.append("<tr>\n" +
                    "\t\t\t\t<th>Device Name</th>\n" +
                    "\t\t\t\t<th>Device Status</th>\n" +
                    "\t\t\t\t<th>Device Scanned Time</th>\n" +
                    "\t\t\t</tr>");
            List<DeviceResponseDTO> deviceResponseDTOS = clientAccountDevicesResponseDTO.getDeviceResponseDTOList();
              for(DeviceResponseDTO deviceResponseDTO : deviceResponseDTOS) {
                sb.append("<tr>");
                sb.append("\n");
                sb.append("<td>");
                sb.append(deviceResponseDTO.getDeviceName());
                sb.append("</td>");
                sb.append("\n");
                sb.append("<td>");
                sb.append(deviceResponseDTO.getStatus());
                sb.append("</td>");
                sb.append("\n");
                sb.append("<td>");
                sb.append(deviceResponseDTO.getScannedTime());
                sb.append("</td>");
                sb.append("</tr>");
            }
            sb.append("</table> ");
            sb.append("</br>");
        }

        sb.append("</br>");
        sb.append("<hr/>");

        if(failedAccountList.size()>0) {
            sb.append("<h2> Failed Accounts (");
            sb.append(failedAccountList.size());
            sb.append(")</h2>");
            for(ClientAccountDevicesResponseDTO clientAccountDevicesResponseDTO : failedAccountList) {
                sb.append("<h3>");
                sb.append(clientAccountDevicesResponseDTO.getUserName());
                sb.append("</h3>");
            }
        }
        sb.append("<br/>");
        sb.append("<hr/>");
        try{
            FileOutputStream fout=new FileOutputStream("D:\\output.html");
            byte b[]=sb.toString().getBytes();
            fout.write(b);
            fout.close();
            System.out.println("success...");
        }catch(Exception e){System.out.println(e);}

    }

    public static void main(String[] args) {
        System.out.println("Testing");
        AutomationResponse automationResponse = new AutomationResponse();
        List<ClientAccountDevicesResponseDTO> clientAccountDevicesResponseDTOS = new ArrayList<>();

        ClientAccountDevicesResponseDTO clientAccountDevicesResponseDT = new ClientAccountDevicesResponseDTO();
        List<DeviceResponseDTO> deviceResponseDTOS = clientAccountDevicesResponseDT.getDeviceResponseDTOList();
        DeviceResponseDTO deviceResponseDTO = new DeviceResponseDTO();
        deviceResponseDTO.setDeviceName("DOT-1");
        deviceResponseDTO.setStatus("Online");
        deviceResponseDTO.setScannedTime(new Date());
        DeviceResponseDTO deviceResponseDTO1 = new DeviceResponseDTO();
        deviceResponseDTO1.setDeviceName("DOT-2");
        deviceResponseDTO1.setStatus("Offline");
        deviceResponseDTO1.setScannedTime(new Date());
        deviceResponseDTOS.add(deviceResponseDTO);
        deviceResponseDTOS.add(deviceResponseDTO1);
        clientAccountDevicesResponseDT.setUserName("ConstantCompanion1@gmail.com");
        clientAccountDevicesResponseDT.setDeviceResponseDTOList(deviceResponseDTOS);
        clientAccountDevicesResponseDTOS.add(clientAccountDevicesResponseDT);

        ClientAccountDevicesResponseDTO clientAccountDevicesResponseDT2 = new ClientAccountDevicesResponseDTO();
        List<DeviceResponseDTO> deviceResponseDTOS2 = clientAccountDevicesResponseDT2.getDeviceResponseDTOList();
        DeviceResponseDTO deviceResponseDTO2 = new DeviceResponseDTO();
        deviceResponseDTO2.setDeviceName("DOT-1");
        deviceResponseDTO2.setStatus("Online");
        deviceResponseDTO2.setScannedTime(new Date());
        DeviceResponseDTO deviceResponseDTO3 = new DeviceResponseDTO();
        deviceResponseDTO3.setDeviceName("DOT-2");
        deviceResponseDTO3.setStatus("Offline");
        deviceResponseDTO3.setScannedTime(new Date());
        deviceResponseDTOS2.add(deviceResponseDTO2);
        deviceResponseDTOS2.add(deviceResponseDTO3);
        clientAccountDevicesResponseDT2.setUserName("ConstantCompanion2@gmail.com");
        clientAccountDevicesResponseDT2.setDeviceResponseDTOList(deviceResponseDTOS2);
        clientAccountDevicesResponseDTOS.add(clientAccountDevicesResponseDT2);

        ClientAccountDevicesResponseDTO clientAccountDevicesResponseDT3 = new ClientAccountDevicesResponseDTO();
        clientAccountDevicesResponseDT3.setUserName("ConstantCompanion3@gmail.com");
        clientAccountDevicesResponseDTOS.add(clientAccountDevicesResponseDT3);
        ClientAccountDevicesResponseDTO clientAccountDevicesResponseDT4 = new ClientAccountDevicesResponseDTO();
        clientAccountDevicesResponseDT4.setUserName("ConstantCompanion4@gmail.com");
        clientAccountDevicesResponseDTOS.add(clientAccountDevicesResponseDT4);


        automationResponse.writeOutput(clientAccountDevicesResponseDTOS);
    }
}
