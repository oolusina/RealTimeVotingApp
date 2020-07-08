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

import java.io.IOException;
import java.util.UUID;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.gson.Gson;
import com.google.sps.data.Survey;

@WebServlet("/data")
public class DataServlet extends HttpServlet {

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
    final String option = "option";
    final String questionValue = request.getParameter(question);
    final String optionValue = request.getParameter(option);

    // Create object to store the survey info into JSON
    Survey survey = new Survey(questionValue, optionValue);

    // Convert JSON by using GSON library
    Gson gson = new Gson();
    String json = gson.toJson(survey);

    // Create entity to store data into database
    final String surveyDataName = "survey";
    Entity SurveyData = new Entity(surveyDataName);
    UUID id = UUID.randomUUID();
    SurveyData.setProperty("id", id.toString());
    SurveyData.setProperty(question, questionValue);
    SurveyData.setProperty(option, optionValue);
    datastore.put(SurveyData);

    // Return JSON to testing
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }
}
