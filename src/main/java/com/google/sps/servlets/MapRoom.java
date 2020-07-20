// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;
import java.net.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.gson.Gson;
import com.google.sps.data.Survey;

@WebServlet("/mapRoom")
public class MapRoom extends HttpServlet {

  DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Query to datastore
    throw new IOException("Implement Get");
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Posting to datastore
    // get all parameter names and its values from HTTP request
    final String question = "question";
    final String option = "markers";
    final String questionValue = request.getParameter(question);
    String [] questionValueIndex = questionValue.split(" ",0);

    // Lower case all string before send to DB
    for (int i = 0; i < questionValueIndex.length;i++)
        questionValueIndex[i] = questionValueIndex[i].toLowerCase();
    // Retrieve the options values into string array then store into StringList for
    // datastore
    //final String[] retrievedOptionValue = request.getParameterValues(option);
    // ISSUE
    System.out.println(request.getParameterValues(option)[0]);
  }
}
